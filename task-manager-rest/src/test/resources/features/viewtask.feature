Feature: View Task Feature

#@smoke
Scenario: View Task Functionality
  Given user navigates to task manager app
  When do point list of tasks
  Then it should load with list of tasks
  

Scenario: filter task list using task name
 # Given user navigates to view task
  When filter task list using task name as "task"
  Then should display task with search string as "task"