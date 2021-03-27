import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {first, map, tap} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [HttpClient]
})
export class AppComponent implements OnInit{
  title = 'frontend';
  message = '';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/message').pipe(
      first(),
      tap(result => console.log('Message received from the server: ', result)),
      map(result => this.message = (result as any).message)
    ).subscribe();
  }

}
