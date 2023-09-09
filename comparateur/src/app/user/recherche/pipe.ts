import { Pipe, PipeTransform } from '@angular/core';
@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
  transform(items: any[], filters: { searchText: string}): any[] {
    if (!items) return [];
    let filteredItems = items;

    if (filters.searchText) {
      filteredItems = filteredItems.filter(item => {
        return item.nomProduit.toLowerCase().includes(filters.searchText.toLowerCase())
       || item.prix_produit == filters.searchText

      });
    }


    return filteredItems;
  }
}