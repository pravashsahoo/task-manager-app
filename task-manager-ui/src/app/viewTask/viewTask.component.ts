import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TaskManagerService } from '../services/task-manager.service';
import { TaskModel } from '../model/task.model';

@Component({
  selector: 'app-viewtask',
  templateUrl: './viewTask.component.html',
  styleUrls: ['./viewTask.component.scss']
})
export class ViewTaskComponent implements OnInit {
  modalRef: BsModalRef;
  taskList: TaskModel[];
  searchString:string;
  index:number;
  filterData:TaskModel= new TaskModel();
  
  alert: any = {
    type: 'success',
    msg: '',
    timeout: 5000
  };
  constructor(private taskManagerServece: TaskManagerService,private modalService: BsModalService) { }

  ngOnInit() {
    this.taskManagerServece.getTask().subscribe(res => {
      this.taskList = res.outData;
      // console.log(this.taskList);
    });
  }

  public endTask(index){
    this.taskManagerServece.endTask(this.taskList[index].taskId).subscribe(r=>this.taskList[index].editEnabled='Y'); 
    // this.taskList[index].flag='Y';
    console.log(this.taskList[index]);
  }
  openModal(template: TemplateRef<any>, i) {
    this.index = i;
    this.modalRef = this.modalService.show(template);
  }

  closeModal() {
    this.modalRef.hide();
    this.alert.msg='';
    // this.index = null;
  }

  public saveOrUpdateTask(i): void {
    this.taskManagerServece.saveTask(this.taskList[i]).subscribe(res => { 
      this.alert.msg = res.outData;
     })
  }


}