import { Injectable } from '@angular/core';
import { TaskModel } from '../model/task.model';
import { ResponseModel } from '../model/response.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of, Subscriber } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { TaskManagerConstants } from '../constants/task-manager.constants';
// import { restoreBindingIndex } from '@angular/core/src/render3/instructions';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};



@Injectable({
  providedIn: 'root'
})
export class TaskManagerService {
  mock: boolean = false;
  constructor(private httpClient: HttpClient) { }

  public saveTask(task: TaskModel): Observable<any> {
    if (TaskManagerConstants.USE_MOCK) {
      let res = new ResponseModel<string>();
      res.errCode = '0';
      res.outData = 'Success';
      res.status = 'Success';
      return new Observable<ResponseModel<string>>((subscriber: Subscriber<ResponseModel<string>>) => subscriber.next(res));
    } else {
      return this.httpClient.post<TaskModel>(TaskManagerConstants.ADD_TASK, task, httpOptions).pipe(
        tap((task: TaskModel) => console.log(`added task w/ id=${task.taskName}`)),
        catchError(this.handleError<TaskModel>('addTask')));
    }

  }

  public getTask(): Observable<any> {
    if (TaskManagerConstants.USE_MOCK) {
      return this.httpClient.get('../../assets/task-list-response.json').pipe(
        tap((res: ResponseModel<TaskModel>) => console.log(`added task w/ id=${res.status}`)),
        catchError(this.handleError<TaskModel>('addTask')));
    } else {
      return this.httpClient.post<ResponseModel<TaskModel>>(TaskManagerConstants.FETCH_TASKS, httpOptions).pipe(
        tap((res: ResponseModel<TaskModel>) => console.log(`added task w/ id=${res.status}`)),
        catchError(this.handleError<TaskModel>('getTasks')));
    }
  }
  public deleteTask(taskId:string){
    return this.httpClient.post<ResponseModel<TaskModel>>('', httpOptions).pipe(
      tap((res: ResponseModel<TaskModel>) => console.log(`added task w/ id=${res.status}`)),
      catchError(this.handleError<TaskModel>('addTask')));
  }
  public endTask(taskId:string){
    let task = new TaskModel();
    task.taskId=taskId;
    task.editEnabled='Y';
    return this.httpClient.post<ResponseModel<string>>(TaskManagerConstants.END_TASK,task, httpOptions).pipe(
      tap((res: ResponseModel<string>) => console.log(`added task w/ id=${res.status}`)),
      catchError(this.handleError<ResponseModel<string>>('addTask')));
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };


  }

}