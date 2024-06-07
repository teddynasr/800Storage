import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

interface User {
  id: number;
  email: string;
  first_name: string;
  last_name: string;
  avatar: string;
}

function sleep(ms: number): Promise<void> {
  return new Promise(resolve => setTimeout(resolve, ms));
}

// Usage
async function run() {
  console.log('Start');
  await sleep(1000); // Sleep for 500 milliseconds
  console.log('End');
}

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  userId: number = 0;
  user: User | undefined;
  loading = true;

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchUserDetails();
  }

  async fetchUserDetails(): Promise<void> {
    this.loading=true;
    await run();
    this.userId=parseInt(this.router.url.split('/')[2]);
    const apiUrl = `https://reqres.in/api/users/${this.userId}`;
    this.http.get<any>(apiUrl).subscribe(
      response => {
        this.user = response.data; // Store the user details
        this.loading = false;
      },
      error => {
        console.error('Error fetching user details:', error);
        this.loading = false;
      }
    );
  }
}
