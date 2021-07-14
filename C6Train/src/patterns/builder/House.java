package patterns.builder;

public class House {
    private boolean hasFoundation;
    private boolean hasFirstStore;
    private boolean hasSecondStore;
    private boolean hasRoof;
    private boolean hasPool;

    public House(HouseBuilder hb) {
        this.hasFoundation = hb.hasFoundation;
        this.hasFirstStore = hb.hasFirstStore;
//        ...
    }

    static class HouseBuilder {
        private boolean hasFoundation;
        private boolean hasFirstStore;
        private boolean hasSecondStore;
        private boolean hasRoof;
        private boolean hasPool;

        public HouseBuilder() {}

        public HouseBuilder hasFoundation(boolean hf) {
            this.hasFoundation = hf;
            return this;
        }

        public HouseBuilder hasFirstStore(boolean fs) {
            this.hasFirstStore = fs;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }


}
