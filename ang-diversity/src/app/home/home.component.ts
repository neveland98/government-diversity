import { Component, OnInit, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  
  constructor(private renderer: Renderer2) { }
  
  ngOnInit(): void {
    this.renderExternalScript('https://public.tableau.com/javascripts/api/viz_v1.js').onload = ()=>{
    }
  }

  renderExternalScript(src: string): HTMLScriptElement{
    const script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = src;
    script.async = true;
    script.defer = true;
    this.renderer.appendChild(document.body, script);
    return script;
  }

}
