import {Component, OnInit} from '@angular/core';
import {FarmerService} from "../../../../_service/farmer.service";
import {environment} from "../../../../../environments/environment";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-farmer-items-view',
  templateUrl: './farmer-items-view.component.html',
  styleUrls: ['./farmer-items-view.component.css']
})
export class FarmerItemsViewComponent implements OnInit {

  items = [];

  constructor(private farmerS: FarmerService, private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.getItems();
  }

  getItems() {
    this.farmerS.getItems().subscribe(items => {
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
}
