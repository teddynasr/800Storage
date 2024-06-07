import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  currentPage: number;
  totalPages: number = 2;

  constructor() {
    const cachedPage = localStorage.getItem('currentPage');
    this.currentPage = cachedPage ? parseInt(cachedPage) : 1;
  }

  @Output() searchByIdEvent = new EventEmitter<number>();
  @Output() showPageEvent = new EventEmitter<number>();
  searchTerm: string = '';

  searchById(userId: string) {
    if(userId.length===0){
      this.showPageEvent.emit(this.currentPage);
    }
    const id = parseInt(userId);
    if (!isNaN(id)) {
      this.searchByIdEvent.emit(id);
    }
  }


  nextPage() {
    this.currentPage++;
    localStorage.setItem('currentPage', JSON.stringify(this.currentPage));
    this.showPageEvent.emit(this.currentPage);
  }

  previousPage() {
    this.currentPage--;
    localStorage.setItem('currentPage', JSON.stringify(this.currentPage));
    this.showPageEvent.emit(this.currentPage);
  }
}
