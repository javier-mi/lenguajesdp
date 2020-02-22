import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { EquationsService } from '../shared/equations/equations.service';
import { GiphyService } from '../shared/giphy/giphy.service';
import { NgForm } from '@angular/forms';
import 'fabric';
declare const fabric: any;
declare var Guppy:any;

@Component({
  selector: 'app-equation-edit',
  templateUrl: './equation-edit.component.html',
  styleUrls: ['./equation-edit.component.css']
})
export class EquationEditComponent implements OnInit, OnDestroy {

  equation: any = {};
  canvas:any = {};
  r = 200; // radius of canvas

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private equationsService: EquationsService,
              private giphyService: GiphyService) {
  }

  ngOnInit() {
      // Inicializar guppy
      var guppy = new Guppy("edit-guppy");
      guppy.activate();
      guppy.event("change",function(e){
          try{
                var fn = e.target.func();
                var F = function(x){ return fn({"x":x,"pi":Math.PI,"e":Math.E}); };
              this.plot(F);
            }
            catch(e){this.draw_axes();}
        });
      this.canvas = new fabric.Canvas('graph');
      
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.equationsService.get(id).subscribe((data: any) => {
          if (data) {
            this.equation = data;
            if(data.equationData){
                guppy.import_xml(this.equation.equationData);
            }
//            this.equation.href = equation._links.self.href;
            // this.giphyService.get(equation.name).subscribe(url => equation.giphyUrl = url);
          } else {
            console.log(`La ecuación con el ID no se econtró '${id}', volviendo al listado general`);
            this.gotoList();
          }
        });
      }
    });
//    guppy.engine.import_latex(this.equation.equationData)
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/equations-list']);
  }

  save(form: NgForm) {
    this.equation.equationData = new Guppy("edit-guppy").xml();
    this.equationsService.save(this.equation).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(equation) {
    this.equationsService.remove(equation.id).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  draw_axes = function() {
      this.canvas.clear();
      this.canvas.add(new fabric.Line([this.r, -1000, this.r, 1000], {
          stroke: "blue",
          strokeWidth: 1,
          selectable: false
      }));
      this.canvas.add(new fabric.Line([-1000, this.r, 1000, this.r], {
          stroke: "blue",
          strokeWidth: 1,
          selectable: false
      }));
  }

plot (f){
    this.draw_axes();
    var points = [];
    for (var x = -this.r; x <= this.r; x++) {
        points.push({
            "x": this.r + x,
            "y": -f(x * 10 / this.r) * this.r / 10 + this.r
        });
    }
    this.canvas.add(new fabric.Polyline(points, {
        fill: null,
        stroke: "red",
        strokeWidth: 2,
        selectable: false
    }));
    this.canvas.renderAll();
}
