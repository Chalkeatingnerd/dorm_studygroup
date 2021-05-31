import InputArea from './InputArea.js'
import SearchButton from './SearchButton.js'

const SearchForm = {
    init(el,btns) {
        this.el = el;

        this.render();
        this.renderChild(btns);
        this.eventHandler();

        return this;
    },
    submit(title, color) {

    },

    eventHandler() {
      const btnWrapper1 = document.querySelector('.btn-wrapper1');
      const btnWrapper2 = document.querySelector('.btn-wrapper2');

      const handler = (evt) => {
        const {color} = evt.detail;
        evt.stopPropagation();
        const title = InputArea.getValue();

        const submitEvent = new CustomEvent('@submit', {detail: {title, color}});
        this.el.dispatchEvent(submitEvent);
      }

      btnWrapper1.addEventListener('@submit', handler);
      btnWrapper2.addEventListener('@submit', handler);
    },

    render() {
        const inputFormEl = `<div class = "input-wrapper"></div>`;
        const searchButtonEl1 = `<div class="btn-wrapper1"></div>`;
        const searchButtonEl2 = `<div class="btn-wrapper2"></div>`;
        this.el.innerHTML = inputFormEl + searchButtonEl1 + searchButtonEl2;
    },

    renderChild(btns) {
        const inputWrapperEl = document.querySelector('.input-wrapper');
        const btnWrapper1 = document.querySelector('.btn-wrapper1');
        const btnWrapper2 = document.querySelector('.btn-wrapper2');
        const SearchBtn1 = Object.create(SearchButton);
        const SearchBtn2 = Object.create(SearchButton);

        InputArea.init(inputWrapperEl);
        SearchBtn1.init(btnWrapper1, btns[0].color, btns[0].title);
        SearchBtn2.init(btnWrapper2, btns[1].color, btns[1].title);
    },
    on(evt, callback) {
        this.el.addEventListener(evt, callback);
    }
};

export default SearchForm;