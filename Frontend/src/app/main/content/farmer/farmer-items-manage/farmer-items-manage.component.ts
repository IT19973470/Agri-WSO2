import {Component, OnInit} from '@angular/core';
import {FarmerService} from "../../../../_service/farmer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-farmer-items-manage',
  templateUrl: './farmer-items-manage.component.html',
  styleUrls: ['./farmer-items-manage.component.css']
})
export class FarmerItemsManageComponent implements OnInit {

  item = {
    description: '',
    price: 0,
    qty: 0,
    userAccount: JSON.parse(localStorage.getItem('user'))
  }

  file: File = null;

  constructor(private farmerS: FarmerService, private router: Router) {
  }

  ngOnInit(): void {
  }

  onChange(event) {
    this.file = event.target.files[0];
  }

  onSubmit() {
    const formData = new FormData();
    formData.append("file", this.file, this.file.name);
    formData.append('item', new Blob([JSON.stringify(this.item)],
      {
        type: "application/json"
      }));

    this.farmerS.addItem(formData).subscribe((item) => {
      this.router.navigate(['/main/farmer/view_items'])
    })
  }
}
