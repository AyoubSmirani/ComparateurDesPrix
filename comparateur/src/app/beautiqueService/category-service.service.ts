
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {
  private selectedCategory = new BehaviorSubject<string>('');

  constructor() { }

  setSelectedCategory(category: string) {
    this.selectedCategory.next(category);
  }

  getSelectedCategory() {
    return this.selectedCategory.asObservable();
  }
}
