import {Component, OnInit} from '@angular/core';
import {FarmerService} from "../../../../_service/farmer.service";
import {DomSanitizer} from "@angular/platform-browser";
import {Router} from "@angular/router";
import {environment} from "../../../../../environments/environment";
import {BuyerService} from "../../../../_service/buyer.service";

@Component({
  selector: 'app-buyer-items-view',
  templateUrl: './buyer-items-view.component.html',
  styleUrls: ['./buyer-items-view.component.css']
})
export class BuyerItemsViewComponent implements OnInit {

  items = [];
  txt;

  constructor(private buyerS: BuyerService, private sanitizer: DomSanitizer, private router: Router) {
  }

  ngOnInit(): void {
    this.getItems();
  }

  getItems() {
    if (this.txt === '') {
      this.txt = undefined;
    }
    this.buyerS.getItems(this.txt).subscribe(items => {
      console.log(items)
      this.items = items;
    })
  }

  getImageSrc(itemPackageImage) {
    // console.log(itemPackageImage)
    // let imageData = 'data:' + itemImg.itemImgType + ';base64,' + itemImg.itemImg;
    // return this.sanitizer.bypassSecurityTrustUrl(imageData);
    return this.sanitizer.bypassSecurityTrustUrl(environment.image_url + itemPackageImage.imgName);
  }

  addToCart(item) {
    let cart = {
      quantity: item.bQty,
      item: item,
      userAccount: {
        email: JSON.parse(localStorage.getItem('user')).email
      }
    }
    console.log(item)
    this.buyerS.addToCart(cart).subscribe((itemObj) => {
      item.qty -= item.bQty;
    })
  }

}
