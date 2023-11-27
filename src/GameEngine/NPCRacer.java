package GameEngine;

/***
 * @deprecated Used in past versions of the game, its use is no longer recommended
 */
    class NPCRacer {
        private String name;
        private String[] raceMessages = {
                "Hello there",
                "Tengo un coche",
                "ABC",
                "abc",
                "Alex ve el xocas"
        };

        /***
         *
         * @param name
         * @return returns npc name
         */
        public NPCRacer(String name) {
            this.name = name;
        }

        /***
         *
         * @return an additional name
         *
         */
        public String getName() {
            return name;
        }

        /***
         *
         * @return already generated NPC messages
         */
        public String generateNPCMessage() {
            int randomIndex = (int) (Math.random() * raceMessages.length);
            return raceMessages[randomIndex];
        }
    }
