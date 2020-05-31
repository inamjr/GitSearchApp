import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Stats } from '../common/stats';
import { SerchService } from '../serch.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css'],
})
export class ItemsComponent implements OnInit {
  stat: Stats[];
  // @Input() users: String[];
  // sid: number = 0;
  // repoId: number = 0;
  // name: string = '';
  // url: string = '';
  // createdDate: string = '';
  // lastPushDate: string = '';
  // numOfStars: number = 0;

  constructor(private githubService: SerchService, private router: Router) {}

  ngOnInit() {}
  getStats() {
    this.githubService.getStat().subscribe((data) => {
      console.log(data);
      this.stat = data;
      console.log(this.stat);
    });
  }
}
