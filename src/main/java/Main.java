import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    static List<Music> musicList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        menu();

    }


    static int opcao() {
        System.out.println("""
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                                ADICIONE SUA MÚSICA
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                             1- Adicionar música
                             2- Listar Músicas
                             3- Buscar
                             4- Filtrar por BPM
                             5- Embaralhar Músicas
                             6- Deletar Músicas
                             0- sair ==========>
                =====================================================
                """);

        int opcao = 0;
        while (true) {
            System.out.println("Opção: ");
            if (!sc.hasNextInt()) {
                System.out.println("Erro! Digite apenas números!");
                sc.nextLine();
                continue;

            }
            opcao = sc.nextInt();
            sc.nextLine();
            break;
        }

        return opcao;
    }

    static void menu() {
        while(true) {
            int opcao = opcao();

            if (opcao == 0) {
                System.out.println("Saindo do programa");
                break;
            }

            switch (opcao) {
                case 1 -> addMusic();
                case 2 -> listMusic();
                case 3 -> searchMusic();
                case 4 -> filterMusic();
                case 5 -> shuffleMusic();
                case 6 -> deleteMusic();

                default -> {
                    System.out.println("Opção inválida");
                    menu();
                }
            }
        }
    }


    static void addMusic() {
        System.out.println("Música: ");
        String name = sc.nextLine();
        System.out.println("Estilo: ");
        String style = sc.nextLine();
        System.out.println("BPM: ");
        int bpm = sc.nextInt();
        sc.nextLine();

        Music music = new Music(name, style, bpm);
        Main.musicList.add(music);

        System.out.println("Música adicionada!");
        menu();
    }


    static void listMusic() {
        System.out.println("+++++++Playlist+++++++");

        for (int i = 0; i < Main.musicList.size(); i++) {
            Music music = Main.musicList.get(i);
            System.out.printf("""
                    +++++++++++++++++++
                    %d Músicas
                    Nome: %s
                    Estilo: %s
                    BPM: %d
                    +++++++++++++++++++
                    """, i, music.getName(), music.getStyle(), music.getBpm());
        }
        menu();
    }

    static void deleteMusic() {
        System.out.println("Remover música\n");
        listMusic();

        while (true) {
            System.out.println("Digite o número da música");
            if (!sc.hasNextInt()) {
                System.out.println("Erro, digite apenas números!\n");
                continue;
            }

            int index = sc.nextInt();
            sc.nextLine();

            if (index >= 0 && index < Main.musicList.size()) {
                System.out.println("Música removida!");

                break;
            } else {
                System.out.println("ERRO. Música não existe");
            }
        }
        menu();

    }

    static void searchMusic() {
        System.out.println("Buscar Música");
        if (musicList.isEmpty()) {
            System.out.println("Nenhuma música encontrada");
            return;
        }
        System.out.println("Música: ");
        String search = sc.nextLine().toLowerCase().trim();

        for (int i = 0; i < musicList.size(); i++) {
            Music music = musicList.get(i);

            if (music.getName().toLowerCase().contains(search)) {
                System.out.printf("""
                        +++++++++++++++
                        Índice: %d
                        Nome: %s
                        +++++++++++++++
                        """, i, music.getName());
            }
        }
        menu();

    }

    static void filterMusic() {
        System.out.println("Filtrar por BPM");
        if (musicList.isEmpty()) {
            System.out.println("Nenhuma música encontrada");
            menu();
            return;
        }

        System.out.println("Digite o BPM desejado: ");
        int bpmDesejado = sc.nextInt();
        sc.nextLine();

        boolean encontrouMusica = false;

        for (int i = 0; i < musicList.size(); i++) {
            Music music = musicList.get(i);

            if (music.getBpm() == bpmDesejado) {
                System.out.printf("""
                        +++++++++++++++++++
                        Índice: %d
                        Nome: %s
                        Estilo: %s
                        BPM: %d
                        +++++++++++++++++++
                        """, i, music.getName(), music.getStyle(), music.getBpm());
                encontrouMusica = true;
            }
        }

        if (!encontrouMusica) {
            System.out.println("Nenhuma música encontrada com esse BPM");
        }
        menu();

    }

    static void shuffleMusic() {
        System.out.println("Embaralhar Playlist");
        if (musicList.isEmpty()) {
            System.out.println("Nenhuma música encontrada");
            menu();
            return;
        }

        List<Music> shuffledList = new ArrayList<>(musicList);
        Collections.shuffle(shuffledList);

        System.out.println("+++++++Playlist Embaralhada+++++++");
        for (int i = 0; i < shuffledList.size(); i++) {
            Music music = shuffledList.get(i);
            System.out.printf("""
                    +++++++++++++++++++
                    Posição: %d
                    Nome: %s
                    Estilo: %s
                    BPM: %d
                    +++++++++++++++++++
                    """, i, music.getName(), music.getStyle(), music.getBpm());
        }
        menu();

    }
}