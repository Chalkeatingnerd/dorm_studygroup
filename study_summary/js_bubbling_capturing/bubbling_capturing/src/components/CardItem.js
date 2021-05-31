

const CardItem = {
    init(el, title, color) {
        this.el = el;
        this.title = title;
        this.color = color;

        this.render();
    },
    render() {
        const cardEl = `
        <div class="card-item" style="background-color: ${this.color}; color: white;">
        ${this.title}
        </div>`;
        this.el.innerHTML = cardEl;
    },
};

export default CardItem;