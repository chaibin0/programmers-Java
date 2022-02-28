package q72410;

class Solution {
    public String solution(String new_id) {
        NewId newId = new NewId(new_id);
        String answer = newId.toLowerCase()
                .removeEtcCharacter()
                .removeContinuePoint()
                .removeFirstPoint()
                .translateEmptyToA()
                .subliceId(15)
                .checkSmallId()
                .getId();
        return answer;
    }

    class NewId {

        private String id;

        public NewId(String new_id) {
            this.id = new_id;
        }

        public NewId toLowerCase() {
            this.id = this.id.toLowerCase();
            return this;
        }

        public NewId removeEtcCharacter() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < id.length(); i++) {
                char c = id.charAt(i);
                if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                    sb.append(c);
                }
            }
            this.id = sb.toString();
            return this;
        }

        public NewId removeContinuePoint() {
            StringBuilder sb = new StringBuilder();

            boolean isContinue = false;
            for (int i = 0; i < id.length(); i++) {
                char c = id.charAt(i);
                if (c == '.') {
                    if (!isContinue) {
                        sb.append(c);
                        isContinue = true;
                    }
                    continue;
                }
                isContinue = false;
                sb.append(c);
            }
            this.id = sb.toString();
            return this;
        }

        public NewId removeFirstPoint() {
            int index = 0;
            if (this.id.charAt(0) == '.') {
                index++;
            }
            StringBuilder sb = new StringBuilder(this.id);
            this.id = sb.substring(index, this.id.length());
            return this;
        }

        public NewId translateEmptyToA() {
            if ("".equals(this.id)) {
                this.id = "a";
            }
            return this;
        }

        public NewId subliceId(int size) {

            StringBuilder sb = new StringBuilder(this.id);
            if (this.id.length() >= size) {
                if (this.id.charAt(size - 1) == '.') {
                    this.id = sb.substring(0, size - 1);
                    return this;
                }
                this.id = sb.substring(0, size);
                return this;
            }

            if (this.id.charAt(this.id.length() - 1) == '.') {
                this.id = sb.substring(0, this.id.length() - 1);
            }
            return this;
        }

        public NewId checkSmallId() {

            if (this.id.length() > 2) {
                return this;
            }

            char lastCharacter = this.id.charAt(this.id.length() - 1);
            StringBuilder sb = new StringBuilder(this.id);
            while (sb.length() <= 2) {
                sb.append(lastCharacter);
            }

            this.id = sb.toString();
            return this;
        }

        public String getId() {
            return id;
        }
    }
}

