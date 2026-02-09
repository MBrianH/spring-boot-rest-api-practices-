package auca.ac.rw.restfullApiAssignment.controller.userprofile;

import auca.ac.rw.restfullApiAssignment.modal.userprofile.ApiResponse;
import auca.ac.rw.restfullApiAssignment.modal.userprofile.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private List<UserProfile> users = new ArrayList<>();

    public UserProfileController() {
        users.add(new UserProfile(1L, "john_doe", "john@example.com", "John Doe", 28, "USA", "Software developer", true));
        users.add(new UserProfile(2L, "jane_smith", "jane@example.com", "Jane Smith", 32, "Canada", "Designer", true));
        users.add(new UserProfile(3L, "mike_wilson", "mike@example.com", "Mike Wilson", 25, "USA", "Student", true));
        users.add(new UserProfile(4L, "sarah_jones", "sarah@example.com", "Sarah Jones", 30, "UK", "Teacher", false));
        users.add(new UserProfile(5L, "tom_brown", "tom@example.com", "Tom Brown", 35, "Australia", "Engineer", true));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserProfile>>> getAllUsers() {
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Users retrieved successfully", users);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> getUserById(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                ApiResponse<UserProfile> response = new ApiResponse<>(true, "User found", user);
                return ResponseEntity.ok(response);
            }
        }
        ApiResponse<UserProfile> response = new ApiResponse<>(false, "User not found", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/search/username")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByUsername(@RequestParam String username) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getUsername().toLowerCase().contains(username.toLowerCase())) {
                result.add(user);
            }
        }
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Search completed", result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/country/{country}")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByCountry(@PathVariable String country) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getCountry().equalsIgnoreCase(country)) {
                result.add(user);
            }
        }
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Users from " + country + " found", result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/age-range")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByAgeRange(@RequestParam int min, @RequestParam int max) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getAge() >= min && user.getAge() <= max) {
                result.add(user);
            }
        }
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Users in age range found", result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<UserProfile>>> getActiveUsers(@RequestParam boolean active) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.isActive() == active) {
                result.add(user);
            }
        }
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Active users retrieved", result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserProfile>> createUser(@RequestBody UserProfile user) {
        users.add(user);
        ApiResponse<UserProfile> response = new ApiResponse<>(true, "User profile created successfully", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> updateUser(@PathVariable Long userId, @RequestBody UserProfile updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(userId)) {
                updatedUser.setUserId(userId);
                users.set(i, updatedUser);
                ApiResponse<UserProfile> response = new ApiResponse<>(true, "User profile updated successfully", updatedUser);
                return ResponseEntity.ok(response);
            }
        }
        ApiResponse<UserProfile> response = new ApiResponse<>(false, "User not found", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PatchMapping("/{userId}/activate")
    public ResponseEntity<ApiResponse<UserProfile>> activateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(true);
                ApiResponse<UserProfile> response = new ApiResponse<>(true, "User activated successfully", user);
                return ResponseEntity.ok(response);
            }
        }
        ApiResponse<UserProfile> response = new ApiResponse<>(false, "User not found", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PatchMapping("/{userId}/deactivate")
    public ResponseEntity<ApiResponse<UserProfile>> deactivateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(false);
                ApiResponse<UserProfile> response = new ApiResponse<>(true, "User deactivated successfully", user);
                return ResponseEntity.ok(response);
            }
        }
        ApiResponse<UserProfile> response = new ApiResponse<>(false, "User not found", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(userId)) {
                users.remove(i);
                ApiResponse<Void> response = new ApiResponse<>(true, "User deleted successfully", null);
                return ResponseEntity.ok(response);
            }
        }
        ApiResponse<Void> response = new ApiResponse<>(false, "User not found", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
