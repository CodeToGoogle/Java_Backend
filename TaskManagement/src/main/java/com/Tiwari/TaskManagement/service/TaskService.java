package com.Tiwari.TaskManagement.service;




import com.Tiwari.TaskManagement.model.Task;
import com.Tiwari.TaskManagement.model.User;
import com.Tiwari.TaskManagement.repository.TaskRepository;
import com.Tiwari.TaskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private User user;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task createTask(Task task) {
        task.setAssignedTo(userRepository.findById(task.getAssignedTo().getId())
                .orElseThrow(() -> new RuntimeException("User not found")));



        ZoneId zoneId;
        if (task.getAssignedTo().getTimeZone() != null) {
            zoneId = ZoneId.of(String.valueOf(task.getAssignedTo().getTimeZone()));
        } else {
            zoneId = ZoneId.of("UTC"); // Default to UTC if no timezone is provided
        }
       /* task.setCreatedAt(ZonedDateTime.now(zoneId).withZoneSameInstant(ZoneId.of("UTC")));
        task.setUpdatedAt(ZonedDateTime.now(zoneId).withZoneSameInstant(ZoneId.of("UTC")));*/

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task taskDetails, String timeZone) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());

        ZoneId zoneId = (timeZone != null) ? ZoneId.of(timeZone) : ZoneId.of(String.valueOf(task.getAssignedTo().getTimeZone()));
       // task.setUpdatedAt(ZonedDateTime.now(zoneId).withZoneSameInstant(ZoneId.of("UTC")));

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found with id " + id));
        taskRepository.delete(task);
    }
}

