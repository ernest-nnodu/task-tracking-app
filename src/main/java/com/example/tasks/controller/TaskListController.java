package com.example.tasks.controller;

import com.example.tasks.domain.dto.TaskListDto;
import com.example.tasks.mappers.TaskListMapper;
import com.example.tasks.service.TaskListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskList()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }
}
