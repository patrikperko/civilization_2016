package view;

public enum CivEnum {

    ANCIENT_EGYPT {
        @Override
        public String toString() {
            return "Ancient Egypt";
        }
    },
    QIN_DYNASTY {
        @Override
        public String toString() {
            return "Qin Dynasty";
        }
    },
    ROMAN_EMPIRE {
        @Override
        public String toString() {
            return "Roman Empire";
        }
    }
}