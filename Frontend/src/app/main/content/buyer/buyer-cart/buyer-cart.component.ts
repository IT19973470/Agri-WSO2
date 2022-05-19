import {Component, OnInit} from '@angular/core';
import {BuyerService} from "../../../../_service/buyer.service";
import {environment} from "../../../../../environments/environment";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-buyer-cart',
  templateUrl: './buyer-cart.component.html',
  styleUrls: ['./buyer-cart.component.css']
})
export class BuyerCartComponent implements OnInit {

  cartDetails = [];
  total = 0;
  cart = {
    delivery: {
      deliveryId: 'dhl'
    },
    payId: ''
  };

  constructor(private buyerS: BuyerService, private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.getCart();
  }

  getCart() {
    this.buyerS.getCart().subscribe((cart) => {
      console.log(cart);
      if (cart !== null) {
        this.cartDetails = cart.cartDetails;
        this.cartDetails.forEach(item => {
          this.total += (item.quantity * item.item.price);
        })
      }
    })
  }

  getImageSrc(itemPackageImage) {
    // console.log(itemPackageImage)
    // let imageData = 'data:' + itemImg.itemImgType + ';base64,' + itemImg.itemImg;
    // return this.sanitizer.bypassSecurityTrustUrl(imageData);
    return this.sanitizer.bypassSecurityTrustUrl(environment.image_url + itemPackageImage.imgName);
  }

  purchase() {
    localStorage.setItem('cart', JSON.stringify(this.cart))
    window.open('http://localhost:4201/login?total=' + this.total, '_blank');
  }
}