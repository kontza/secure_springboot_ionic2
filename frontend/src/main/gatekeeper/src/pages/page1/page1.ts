import { Component } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { NavController } from 'ionic-angular';

@Component({
    selector: 'page-page1',
    templateUrl: 'page1.html'
})
export class Page1 {
    public greeting: any = {
        id: 666,
        content: 'Your wish is my command...'
    };

    constructor(
        public navCtrl: NavController,
        private http: Http
    ) {
    }

    ionViewWillEnter() {
        console.error('>>> View entering...');
        var headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        headers.append("Authorization", "Basic " + btoa("user:password"));

        this.http.get('/greeting', { headers: headers })
            .subscribe(data => {
                let receivedGreeting = data.json();
                console.error('>>> receivedGreeting:', receivedGreeting);
                this.greeting = receivedGreeting;
            }, err => {
                if (err.status < 400) {
                    console.error('>>> Status < 400 && Status != 200');
                }
            });
    }
}
