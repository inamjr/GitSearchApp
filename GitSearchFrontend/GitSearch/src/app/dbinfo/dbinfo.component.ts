import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Stats } from '../common/stats';
import { SerchService } from '../serch.service';

@Component({
  selector: 'app-dbinfo',
  templateUrl: './dbinfo.component.html',
  styleUrls: ['./dbinfo.component.css'],
})
export class DbinfoComponent implements OnInit {
  statdb: Stats[];

  constructor(private githubService: SerchService, private router: Router) {}

  ngOnInit() {}
  async getdbInformation() {
    this.statdb = await this.githubService.getdbInfo();
    console.log(this.statdb);
  }
}
