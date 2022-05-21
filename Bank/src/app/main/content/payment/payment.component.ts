import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../../../_service/login.service';
import {PaymentService} from '../../../_service/paymentService';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor(private router: Router, private loginService: LoginService, private paymentService: PaymentService) {
  }


  amount: any;
  payment = {
    transactionID: '',
    card: '',
    nic: '',
    amount: '',
    email: '',
    cardType: '',
    cvc: '',
    expirationYear: '',
    expirationMonth: ''
  };


  ngOnInit(): void {
    this.payment.nic = this.loginService.payment.nic;
    this.payment.email = this.loginService.payment.email;
    this.payment.amount = this.loginService.payment.amount;
    this.payment.cardType = this.loginService.payment.cardType;
    console.log(this.loginService.payment.nic);
    console.log(this.loginService.payment.email);
    console.log(this.loginService.payment.amount);
    this.amount = this.loginService.payment.amount;
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    console.log(this.payment.expirationYear);
    // this.loginService.payment.nic = this.user.nic;
    // this.loginService.payment.email = this.user.email;
    // this.loginService.payment.amount = this.user.amount;
    this.paymentService.addPayment(this.payment).subscribe((payment) => {
      console.log(payment);
      window.location.href = 'http://localhost:4200/main/buyer/pay_success?payId=' + payment.transactionID;
    })
  }


}
