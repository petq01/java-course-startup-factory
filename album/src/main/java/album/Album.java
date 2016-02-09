/**
 * 
 */
package album;

/**
 * @author Petq
 *
 */
public class Album {
	private String nameAlbum;
	private String totalSongs;
	public String getNameAlbum() {
		return nameAlbum;
	}
	public void setNameAlbum(String nameAlbum) {
		this.nameAlbum = nameAlbum;
	}
	public String getTotalSongs() {
		return totalSongs;
	}
	public void setTotalSongs(String totalSongs) {
		this.totalSongs = totalSongs;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The name of the album is is: ").append(nameAlbum).append(". totalOfSongs: ").append(totalSongs);
		return sb.toString();
	}
	public Album(String nameAlbum, String totalSongs) {
		super();
		this.nameAlbum=nameAlbum;
		this.totalSongs=totalSongs;
	}

}
