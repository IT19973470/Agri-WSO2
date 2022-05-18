import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {MainComponent} from "./main/main.component";
import {FarmerItemsViewComponent} from "./main/content/farmer/farmer-items-view/farmer-items-view.component";
import {FarmerItemsManageComponent} from "./main/content/farmer/farmer-items-manage/farmer-items-manage.component";
import {FarmerComponent} from "./main/content/farmer/farmer.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'main',
    component: MainComponent,
    children: [
      {
        path: 'farmer',
        component: FarmerComponent,
        children: [
          {
            path: 'view_items',
            component: FarmerItemsViewComponent
          },
          {
            path: 'manage_items',
            component: FarmerItemsManageComponent
          }
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
