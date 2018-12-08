import { Component, OnInit } from '@angular/core';
import { EquationsService } from '../shared/equations/equations.service';

@Component({
  selector: 'app-equations-list',
  templateUrl: './equations-list.component.html',
  styleUrls: ['./equations-list.component.css']
})
export class EquationsListComponent implements OnInit {
  equations: Array<any>;

  constructor(private equationsService: EquationsService) { }

  ngOnInit() {
    this.equationsService.getAll().subscribe(data => {
      this.equations = data;
    });
  }

}
