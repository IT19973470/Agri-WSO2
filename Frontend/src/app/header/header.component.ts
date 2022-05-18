import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  topic;
  username;

  constructor() { }

  ngOnInit(): void {
    this.username = localStorage.getItem('user') !== null ? JSON.parse(localStorage.getItem('user'))['name'] : ''
  }

}
