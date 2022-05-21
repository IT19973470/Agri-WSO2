import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../../_service/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card-type',
  templateUrl: './card-type.component.html',
  styleUrls: ['./card-type.component.css']
})
export class CardTypeComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    console.log(this.loginService.payment.nic)
  }

  visa() {
    this.loginService.payment.cardType = 'Visa';
    console.log( this.loginService.payment);
    this.router.navigate(['main/payment']);
  }

  master() {
    this.loginService.payment.cardType = 'Master'
    console.log( this.loginService.payment);
    this.router.navigate(['main/payment']);
  }

  amex() {
    this.loginService.payment.cardType = 'Amex'
    console.log( this.loginService.payment);
    this.router.navigate(['main/payment']);
  }
}
