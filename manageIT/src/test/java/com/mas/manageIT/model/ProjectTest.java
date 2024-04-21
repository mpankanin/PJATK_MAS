package com.mas.manageIT.model;

import com.mas.manageIT.model.enums.TaskType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectTest {

    @Test
    void should_find_association_by_id() {
        // given
        Project project = new Project(1L, "Project", "Description", LocalDate.now(), null, null);
        Task task = new Task(1L, "Task", TaskType.RESEARCH, LocalDate.now(), null, null, null, null);

        // when
        project.addTaskQualified(task);

        // then
        assertTrue(project.getTasksQualified().containsKey(1L));
        try {
            assertEquals(project.findTaskQualified(1L), task);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
