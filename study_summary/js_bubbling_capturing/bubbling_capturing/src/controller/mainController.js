import SearchForm from '../components/SearchForm.js';
import ResultForm from '../components/ResultForm.js'

const mainController = {
    setUp() {
      const btns = [
        {color: 'red', title: 'red submit'},
        {color: 'blue', title: 'blue submit'},
      ]
      const searchFormEL = document.querySelector('.search-form');
      const resultFormEL = document.querySelector('.result-form');
      
      SearchForm.init(searchFormEL, btns)
                .on('@submit', (evt) => { this.add(evt.detail.title, evt.detail.color); });

      ResultForm.init(resultFormEL);
    },

    add(title, color) {
      ResultForm.add(title, color);
    }
}

export default mainController;