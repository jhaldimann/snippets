import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NewSnippetComponent} from "./pages/new-snippet/new-snippet.component";
import {SnippetsComponent} from "./pages/snippets/snippets.component";

const routes: Routes = [
  { path: 'add-new-component', component: NewSnippetComponent },
  { path: 'snippets', component: SnippetsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {  }
