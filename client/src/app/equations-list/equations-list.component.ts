import { Component, OnInit } from '@angular/core';
import { EquationsService } from '../shared/equations/equations.service';
import { GiphyService } from '../shared/giphy/giphy.service';
declare var Guppy:any;

@Component({
  selector: 'app-equations-list',
  templateUrl: './equations-list.component.html',
  styleUrls: ['./equations-list.component.css']
})
export class EquationsListComponent implements OnInit {
  equations: Array<any>;

  constructor(private equationsService: EquationsService, private giphyService: GiphyService) { }

  ngOnInit() {
    this.equationsService.getAll().subscribe(data => {
      this.equations = data;
      for (const equation of this.equations) {
//          var guppy = new Guppy("equation"+equation.id);
//          guppy.activate();
        this.giphyService.get(equation.name).subscribe(url => equation.giphyUrl = url);
      }
    });
  }

}
