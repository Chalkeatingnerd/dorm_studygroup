import CardItem from './CardItem.js';

const ResultForm = {
    init(el) {
        this.el = el;
        this.items = [];
        this.render();
        this.renderChild();
    },
    add(title, color) {
        this.items.push({title, color});
        console.log(this.items);
        this.render();
        this.renderChild();
    },

    render() {
        const createWrapper = (num) => `<div class="card-wrapper${num}"></div>`
        let html='';
        for(let i=0; i<this.items.length;i++) {
            html += createWrapper(i);
        }

        this.el.innerHTML = html;
    },
    renderChild() {
        this.items.forEach((x, idx) => {
            const cardWrapperEl = document.querySelector(`.card-wrapper${idx}`);
            CardItem.init(cardWrapperEl, x.title, x.color); 
        });
    }
};

export default ResultForm;