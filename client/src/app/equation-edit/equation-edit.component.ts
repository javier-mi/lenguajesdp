import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { EquationsService } from '../shared/equations/equations.service';
import { GiphyService } from '../shared/giphy/giphy.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-equation-edit',
  templateUrl: './equation-edit.component.html',
  styleUrls: ['./equation-edit.component.css']
})
export class EquationEditComponent implements OnInit, OnDestroy {

  equation: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private equationsService: EquationsService,
              private giphyService: GiphyService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.equationsService.get(id).subscribe((equation: any) => {
          if (equation) {
            this.equation = equation;
            this.equation.href = equation._links.self.href;
            this.giphyService.get(equation.name).subscribe(url => equation.giphyUrl = url);
          } else {
            console.log(`Equation with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/equations-list']);
  }

  save(form: NgForm) {
    this.equationsService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.equationsService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
