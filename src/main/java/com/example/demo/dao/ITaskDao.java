package com.example.demo.dao;

import com.example.demo.domain.Task;

import java.util.List;

public interface ITaskDao {

    List<Task> findAll();

    // Task findOne();
}
