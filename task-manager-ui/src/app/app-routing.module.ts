import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddTaskComponent } from './addTask/addTask.component';
import { ViewTaskComponent } from './viewTask/viewTask.component';
import { AppComponent } from './app.component';

const routes: Routes = [
{path:'', redirectTo:'/viewtask',pathMatch: 'full'},
// {path:'/taskmanager', component:AppComponent},
{path:'addtask',component:AddTaskComponent},
{path:'viewtask',component:ViewTaskComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
