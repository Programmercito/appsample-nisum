import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  sourceCodeLink = 'https://github.com/Programmercito/appsample-nisum';
  diagramLink = 'https://github.com/Programmercito/appsample-nisum/raw/main/diagrama.png?raw=true';
  databaseLink = 'http://h2database.com/html/main.html';
  h2library = "https://github.com/h2database/h2database/releases/download/version-2.2.224/h2-mvstore-2.2.224.jar";
  githubprofile = "https://github.com/Programmercito";
  githubv21 = "https://github.com/Programmercito/appsample-nisum/tree/4f9adec6d7931df74eb36da48a33ca1130026d30"
  constructor() {
  }
  ir(link: string) {
    switch (link) {
      case "codigo": {
        window.open(this.sourceCodeLink, "_blank");
        break;
      }
      case "diagrama": {
        window.open(this.diagramLink, "_blank");
        break;
      }
      case "h2": {
        window.open(this.databaseLink, "_blank");
        break;
      }
      case "lib": {
        window.open(this.h2library, "_blank");
        break;
      }
      case "github": {
        window.open(this.githubprofile, "_blank");
        break;
      }
      case "github21": {
        window.open(this.githubv21, "_blank");
        break;
      }
    }
  }
}
