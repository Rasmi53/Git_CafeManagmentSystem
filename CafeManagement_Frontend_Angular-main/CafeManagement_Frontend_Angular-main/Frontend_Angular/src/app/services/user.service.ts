import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UserService {

  url=environment.getApiUrl("auht");

  constructor(private http: HttpClient) {}

  signup(data: any) {
    return this.http.post(this.url + '/user/signup', data, {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
    });
  }

  login(data: any) {
    return this.http.post(this.url + '/user/login', data, {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
    });
  }

  checkToken() {
    return this.http.get(this.url + '/user/checkToken');
  }

  chagePassWord(data: any) {
    return this.http.post(this.url + '/user/changePassword', data, {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
    });
  }

  getAllUser(){
    return this.http.get(this.url + '/user/get');

  }

  forgotPassword(data:any){
    return this.http.post(this.url + '/user/forgotPassword', data, {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
    });
  }

  sendDataToBackend(data:any){
    return this.http.post(this.url + '/user/otp', data, {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
    });
  }


  updateStatus(data:any){
    return this.http.post(this.url+"/user/update",data,{
      headers:new HttpHeaders().set('Content-Type',"application/json")
    })
  }

}
