package org.example.vehicleservice3.DTO;

public class WorkerDTO {
    private Long workerId;
    private String name;
    private String role;
    private String email;

    public WorkerDTO() {}

    public WorkerDTO(Long workerId, String name, String role, String email) {
        this.workerId = workerId;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public Long getWorkerId() { return workerId; }
    public void setWorkerId(Long workerId) { this.workerId = workerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}