import { Pipe, PipeTransform } from '@angular/core';
import { TaskModel } from '../model/task.model';
import { FLAGS } from '@angular/core/src/render3/interfaces/view';

@Pipe({
  name: 'viewTask'
  // ,pure:false
})
export class ViewTaskPipe implements PipeTransform {

  transform(tasks: TaskModel[], val?: string): any {
    console.log('val',val);
    if (!val) {
      return tasks;
    }
    return tasks.filter(t => {
           return (t.taskName.startsWith(val));
    }
    );
  }

}
