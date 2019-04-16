Feature: Add Task Feature

#@smoke
Scenario Outline: Add Task Functionality
  Given navigate to add task
  When add task taskName as "coding" parentTask as "planning"
  Then should be added new task 
  
    
 
