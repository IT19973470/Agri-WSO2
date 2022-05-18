import { Component, OnInit } from '@angular/core';
import {NavbarService} from "../../../_service/navbar.service";

@Component({
  selector: 'app-nav-farmer',
  templateUrl: './nav-farmer.component.html',
  styleUrls: ['./nav-farmer.component.css']
})
export class NavFarmerComponent implements OnInit {

  constructor(private navBarService: NavbarService) { }

  ngOnInit(): void {
  }

  setTopic(topic){
    this.navBarService.navTopic.next(topic);
  }
}
