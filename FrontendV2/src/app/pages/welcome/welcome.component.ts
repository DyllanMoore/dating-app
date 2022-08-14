import { Component, Input, OnInit } from '@angular/core';
import { ThemePalette, MatRipple } from '@angular/material/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css'],
})
export class WelcomeComponent implements OnInit {
  @Input()
  color: ThemePalette = 'accent';

  defaultColor: ThemePalette = 'accent';

  constructor() {}

  ngOnInit(): void {}
}
