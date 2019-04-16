import { Component, OnInit } from '@angular/core';
import { TaskModel } from '../model/task.model';
import { ParentTaskModel } from '../model/parent-task.model';
import { TaskManagerService } from '../services/task-manager.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './addTask.component.html',
  styleUrls: ['./addTask.component.scss']
})
export class AddTaskComponent implements OnInit {
  task: TaskModel;
  alert: any = {
    type: 'success',
    msg: '',
    timeout: 5000
  };;

  constructor(private taskManagerService: TaskManagerService) { 
    this.task = new TaskModel();
    this.task.priority='0';
    this.task.parentTask = new ParentTaskModel();
  }

  ngOnInit() {
  }

  public saveOrUpdateTask(): void {
    this.taskManagerService.saveTask(this.task).subscribe(res => { 
      this.alert.msg= res.outData;
     })
  }

  public reset():void{
    this.task.endDate='';
    this.task.startDate='';
    this.task.priority='0';
    this.task.taskName='';
    this.task.parentTask.parentTask=''
    this.task.parentTask.parentId='';
    this.alert.msg='';
  }


}
