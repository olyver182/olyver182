import java.io.*;
import java.util.Scanner;

public class Cadastrar {
	
	private Scanner scan = new Scanner(System.in);
	private Playlist playlist = new Playlist();
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream outObjectStream;
	
  
	public int mostarMenu()
	{
	int seleção;

		System.out.print("\nCadastro de Musicas"
						+ "\n1- Cadastrar Musicas"+ "\n2- Ver Musicas"
						+ "\n3- Editar Musicas" + "\n4- Remover Musica" + "\n5- Deletar da Lista"
						+ " \n6- Sair" + "\nSelecione uma opção: ");
		seleção = scan.nextInt();
		System.out.print("\n");
		return seleção;
	}
  public void executarMenu()
	{
   int seleção = mostarMenu();
  	switch (seleção) {
		case 1:
			addMusicas();
			salvarPlaylist();
			executarMenu();
			break;
		case 2:
			verPlaylist();
			executarMenu();
			break;
		case 3:
			atualizarMusicas();
			salvarPlaylist();
			executarMenu();
			break;
		case 4:
			removerMusica();
			salvarPlaylist();
			executarMenu();
			break;
		case 5:
			playlist.deletePlaylist();
			executarMenu();
			break;
		case 6:
			salvarPlaylist();
			System.exit(0);
			break;
		default:
			System.out.println("\nEsta opção não é valida!\n");
			executarMenu();
		}
	}
  public void addMusicas()
	{
		Lista_de_Musicas novaMusica = new Lista_de_Musicas();
		
		novaMusica.setArtista(scan.nextLine());
		System.out.print("Digitar Musica: ");
		novaMusica.setTitulo(scan.nextLine());
		System.out.print("Digitar Artista: ");
		novaMusica.setAlbums(scan.nextLine());
		System.out.print("Digitar Album: ");
		novaMusica.setGenero(scan.nextLine());
		System.out.print("Digitar Genero: ");
		novaMusica.setAnos(scan.nextLine());
		System.out.print("Digitar Ano: ");
		novaMusica.setDuração(scan.nextLine());
		System.out.print("Digitar Duração: ");
		scan = new Scanner(System.in);
		if (duracao(novaMusica)) {
			novaMusica.setDuração(scan.nextLine());
			System.out.print("Digitar Duração: ");
                
             
            }
                else {
                System.out.println("Selecio a opção desejada:\n"
                        + "[1] Tentar Novamente \n"
                        + "[0]  Voltar ao Menu \n"
                        + "___________________________________________________________");
                int opcao = scan.nextInt();
                if (opcao == 1) {
                	addMusicas();
                } else {
         
		playlist.novaMusica(novaMusica);
	}
                }}
	
 	private boolean duracao(Lista_de_Musicas novaMusica) {
	// TODO Auto-generated method stub
	return false;
}
	public void verPlaylist()	{
		  if(playlist.getPlaylistSize() == 0)
		{
			System.out.println("\nLista vazia!");
		}
		else
		{
			for(int i = 0; i < playlist.getPlaylistSize(); i++)
			{
				System.out.print((i+1) + " Nome: ");
				System.out.print(playlist.getArtista(i) +"");
				System.out.print(playlist.getTitulo(i)+ "/ Titulo ");
				System.out.print(playlist.getAlbum(i)+"/ Album: ");
				System.out.print(playlist.getGenero(i)+"/ Genero: ");
				System.out.print(playlist.getAno(i)+"/ Ano: ");
				System.out.print(playlist.getDuração(i)+"/ Duração: ");
				System.out.print(playlist.getDuração(i)+ "\n/.");
			    System.out.print("\n");
			}
	    }
	}	
	public boolean atualizarMusicas()
	{
		if(playlist.getPlaylistSize() == 0)
		{
			System.out.println("\nLista vazia!");
		}
		else
		{
			verPlaylist();
			System.out.print("\n\r\n" +"Selecione uma música para editar: ");
			int songSelection = scan.nextInt();
			
			System.out.print("\nO que você gostaria de atualizar?\n"+"1- nome\n"+"2- artista\n"
							+"3- genero\n"+"4- album\n"+"5- Ano\n"+"6- duração\n"+"Selecione uma opção: ");
			
			int updateSelection = scan.nextInt();
			
			switch (updateSelection) {
			case 1:
				System.out.print("Digitar artista: ");
				String artista = scan.next();
				playlist.updateArtist(songSelection,artista);
				break;
			case 2:
				System.out.print("Digitar titulo: ");
				String titulo = scan.next();
				playlist.updateTitulo(songSelection,titulo);
				break;
			case 3:				
				System.out.print("Digitar Album: ");
				String album = scan.next();
				playlist.updateAlbum(songSelection,album);
				break;
			case 4:				
				System.out.print("Digitar Genero: ");
				String genero = scan.next();
				playlist.updateGenero(songSelection,genero);
				break;				
		    case 5:
				System.out.print("Digitar Ano: ");
				String ano = scan.next();
				playlist.updateAno(songSelection,ano);
				break;
			case 6:
				System.out.print("Digitar duração: ");
				int duraçãos = scan.nextInt(0);
				playlist.updateDuração(songSelection,duraçãos);
				break;
				}
				System.out.println("\nAtulizado!\n");
				executarMenu();
			}
		return false;
		}
	public  void removerMusica(){
  
		if(playlist.getPlaylistSize() == 0)
		{
			System.out.println("\nLista vazia!");
		}
		else
		{
			
			verPlaylist();
						
			boolean flag = false;
			do
			{
				
				System.out.print("\nSelecionar a Musica para remover: ");
				int removeSelection = scan.nextInt();
					if(removeSelection < playlist.getPlaylistSize() || removeSelection > playlist.getPlaylistSize())
				{
					System.out.print("Esta opção não é valida!\n");
				}
				else
				{
					playlist.removeSong(--removeSelection);
					flag = true;
				}
					
			} while(flag == false);
		}
	
		
	}
  public void salvarPlaylist()
	{
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream("Lista de Musica");
			outObjectStream = new ObjectOutputStream(fileOutputStream);
			outObjectStream.writeObject(playlist);
			outObjectStream.flush();
			outObjectStream.reset();
		}
		catch(FileNotFoundException fnfException)
		{
			System.out.println("Nenhum arquivo");
			return;
		}
		catch(IOException ioException)
		{	
			System.out.println();
			return;
		}
	}
	public void loadPlaylist()
	{
		try
		{
			FileInputStream fileInputStream = new FileInputStream("playlist");
			objectInputStream = new ObjectInputStream(fileInputStream);
			playlist = (Playlist)objectInputStream.readObject();
			objectInputStream.reset();
		}
		catch(FileNotFoundException fnfException)
		{
			System.out.println("Nenhum arquivo");
			return;
		}
		catch(IOException ioException)
		{	
			System.out.println("");
			return;
		}
			catch(ClassNotFoundException cnfException)
		{	
			System.out.println("Esta não é uma lista de reprodução.");
		}
	}
}