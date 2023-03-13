package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program
{
	// DESAFIO PLATAFORMA DE ENSINO
	
	public static void main(String[] args)
	{
		List<Lesson> lista = new ArrayList<>();
		
		try (Scanner scn = new Scanner(System.in))
		{
			System.out.print("Quantas aulas tem o curso? ");
			int n = scn.nextInt();
			System.out.println();
			
			for (int i = 0; i < n; i++)
			{
				System.out.println("Dados da " + (i + 1) + "ª aula:");
				
				System.out.print("Conteúdo ou tarefa (c/t)? ");
				char resp = scn.next().charAt(0);
				
				System.out.print("Título: ");
				scn.nextLine();
				String titulo = scn.nextLine();
				
				if (resp == 'c')
				{
					System.out.print("URL do vídeo: ");
					String url = scn.nextLine();
					System.out.print("Duração em segundos: ");
					Integer duracao = scn.nextInt();
					Lesson licao = new Video(titulo, url, duracao);
					lista.add(licao);
				}
				else if (resp == 't')
				{
					System.out.print("Descrição: ");					
					String descricao = scn.nextLine();
					System.out.print("Quantidade de questões: ");
					Integer quantidade = scn.nextInt();
					Lesson licao = new Task(titulo, descricao, quantidade);
					lista.add(licao);
				}
				System.out.println();
			}			
			
			int total = 0;
			for (Lesson l : lista)
			{
				total = total + l.duration();
			}
			
			System.out.println("DURAÇÃO TOTAL DO CURSO = " + total + " segundos");
			
			scn.close();
		}

	}

}
