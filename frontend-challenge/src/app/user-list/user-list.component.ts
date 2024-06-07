import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

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
  await sleep(1000);
  console.log('End');
}

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: User[] = [];
  loading = false;
  error = '';
  currentPage: number = 1;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    const cachedPage = localStorage.getItem('currentPage');
    this.fetchUsers(cachedPage ? parseInt(cachedPage) : 1);
  }

  async fetchUsers(page: number) : Promise<void> {
    this.loading = true;
    await run();
    const apiUrl = `https://reqres.in/api/users?page=${page}`;

    this.http.get<any>(apiUrl).pipe(
      catchError(error => {
        this.loading = false;
        this.error = 'Failed to fetch users. Please try again later.';
        return throwError(error);
      })
    ).subscribe(response => {
      this.loading = false;
      this.users = response.data;
      this.currentPage = page; // Update current page
    });
  }

  async searchUserById(userId: number) : Promise<void> {
    this.loading = true;
    await run();
    const apiUrl = `https://reqres.in/api/users/${userId}`;
  
    this.http.get<any>(apiUrl).subscribe(
      response => {
        this.loading = false;
        if (response.data) {
          this.users = [response.data]; // Update the users array with the found user
          this.error = ''; // Clear any previous error message
        } else {
          this.error = 'User not found. Please enter a valid ID.';
        }
      },
      error => {
        this.loading = false;
        this.error = 'User not found. Please enter a valid ID.';
        this.users = []; // Clear the users array if an error occurs
      }
    );
  }

  onShowPage(page: number) {
    this.fetchUsers(page);
  }
}
