import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private router: Router) {}

    isUserDetailsRoute(): boolean {
      const urlParts = this.router.url.split('/'); // Split the URL by '/'
      if (urlParts.length === 3 && urlParts[1] === 'users') { // URL should have three parts: ['','users', {id}]
          const userId = urlParts[2];
          console.log(userId);
          return /^\d+$/.test(userId);
      }
      console.log("False");
      return false; // Return false if the URL doesn't match the expected format
  }
}
